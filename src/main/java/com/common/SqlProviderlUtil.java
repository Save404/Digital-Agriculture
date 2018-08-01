package com.common;

<<<<<<< HEAD:src/main/java/com/common/SqlProviderlUtil.java
import com.common.commonUtils.StringUtils;
=======
import com.util.commonUtils.StringUtils;
>>>>>>> origin/master:src/main/java/com/util/SqlProviderlUtil.java
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;
import java.util.*;

public class SqlProviderlUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 传入数据的表名与数据库字段和对象属性值构成的map，动态生成insert的sql语句
     * @param tableName
     * @param map
     * @return
     */
    public static String returnInsertSql(final String tableName, final Map<String, Object>map){
        return new SQL() {{
            INSERT_INTO(tableName);

            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String, Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value != null){
                    if (value instanceof String){
                        VALUES(key, StringUtils.addQuotationMarks(value.toString()));
                    }else if(value instanceof Date){
                        VALUES(key, StringUtils.addQuotationMarks(sdf.format(value)));
                    }else{
                        VALUES(key, value.toString());
                    }
                }
            }
        }}.toString();
    }

//    private static List<Object> getObjectAllFields(Object obj){
//
//        Field fields[] = obj.getClass().getDeclaredFields();
//        List<Object> values = new ArrayList<Object>();
//
//        try{
//            Field.setAccessible(fields, true);
//            for(int i = 0; i < fields.length; ++i){
//                values.add(fields[i].get(obj));
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return values;
//    }
//

    //
//    /**
//     * 传入需要插入记录的数据表的表名和对应的对象，动态生成insert的sql语句(对象为null的属性不会添加到sql语句)
//     * @param obj
//     * @param tableName
//     * @return 动态生成的sql字符串
//     */
//    public String getInsertSql(Object obj, String tableName){
//
//        List<String> keys =  dao.getColumns(tableName);
//        List<Object> values = getObjectAllFields(obj);
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        for (int i = 0; i < keys.size(); ++i){
//            map.put(keys.get(i), values.get(i));
//        }
//
//        return returnInsertSql(tableName, map);
//    }

//    public static String getInsertSql(String tableName, List<String> columns, Object obj){
//        List<Object> values = getObjectAllFields(obj);
//        Map<String, Object>map = new HashMap<String, Object>();
//
//        for (int i = 0; i < columns.size(); ++i){
//            map.put(columns.get(i),values.get(i));
//        }
//        return returnInsertSql(tableName, map);
//    }
//


}
