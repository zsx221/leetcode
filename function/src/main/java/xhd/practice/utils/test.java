package xhd.practice.utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSONArray;
import lombok.val;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {

    public static void main(String[] args) throws Exception {
        System.out.println((findEnergByServiceSiChuan(new String[]{"00:00~13:00","13:00~24:00"},new String[]{"2,2","3,2"})));
    }
    /**
     * 按照指定小时分割时间段
     * @param dateType 类型 M/D/H/N -->每月/每天/每小时/每分钟
     * @param dBegin
     * @param dEnd 结束时间
     * @param time 指定小时(如：1、2、3、4)
     * @return
     */
    public static List<String> findDates(String dateType, Date dBegin, Date dEnd, int time) throws Exception {
        List<String> listDate = new ArrayList<>();
        listDate.add(new SimpleDateFormat("HH:mm:ss").format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (calEnd.after(calBegin)) {
            if ("N".equals(dateType)){
                calBegin.add(Calendar.MINUTE , time);
            }
            if (calEnd.after(calBegin)){
                listDate.add(new SimpleDateFormat("HH:mm:ss").format(calBegin.getTime()));
            }
            else{
                // listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(calEnd.getTime()));
            }

        }
        return listDate;
    }

    private static String findEnergByServiceSiChuan(String[] timeList, String[] priceList) throws Exception {
        JSONObject result=new JSONObject(new LinkedHashMap());
        //JSONObject result = new JSONObject(new LinkedHashMap());
        com.alibaba.fastjson.JSONObject electricityFees=new com.alibaba.fastjson.JSONObject(new LinkedHashMap());
        com.alibaba.fastjson.JSONObject serviceFees=new com.alibaba.fastjson.JSONObject(new LinkedHashMap());
        int i=0,j=0;
        List<String> list = getTimeList();
        while (i < timeList.length&&j<list.size()){
            if (org.apache.commons.lang3.StringUtils.isNotBlank(timeList[i])){
                String[] strings = list.get(j).split("-");
                String[] times = timeList[i].split("~");
                if (judge(strings[0],strings[1],times[0],times[1])){//在这个时间段
                    electricityFees.put(list.get(j),priceList[i].split(",")[0]);
                    serviceFees.put(list.get(j),priceList[i].split(",")[1]);
                    j++;
                    continue;
                }
                i++;
            }
        }
        result.put("electricityFees",electricityFees);
        result.put("serviceFees",serviceFees);
        return result.toString();
    }

    private static List<String> getTimeList() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String startDate = "".concat("00:00:00");
        String endDate = "".concat("24:00:00");
        Date dBegin = sdf.parse(startDate);
        Date dEnd = sdf.parse(endDate);
        List<String> list = findDates("N", dBegin, dEnd,30);
        List<String>result=new ArrayList<>();
        list.add("24:00:00");
        int  size = list.size();
        for (int i=1;i<size;i++){
            result.add(list.get(i-1)+"-"+list.get(i));
        }
        for (String str :result){
            System.out.println(str);
        }
        return result;
    }

    public static boolean judge(String date1, String date2, String startTime, String endDate) throws ParseException {
        long d1 = new SimpleDateFormat("HH:mm").parse(date1).getTime();
        long d2 = new SimpleDateFormat("HH:mm").parse(date2).getTime();
        long start = new SimpleDateFormat("HH:mm").parse(startTime).getTime();
        long end = new SimpleDateFormat("HH:mm").parse(endDate).getTime();
        if (((d1  - start) >= 0) && ((end - d2) >= 0)
        ){
            return true;
        }
        return false;
    }

}
