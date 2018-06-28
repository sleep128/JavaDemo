package com.sleep.myUtil.mysqlDDL;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreateTableMysql {

    private static final String coSql  = "\n  %s %s %s comment '%s',";
    private static final String sql    = "--%s\ncreate table %s (%s %s" + "\n)%s;\n\n";

    private static final String common = "\n  ID bigint not null primary key auto_increment comment 'ID',"
                                         + "\n  IS_DELETED char(1) comment '是否删除',"
                                         + "\n  GMT_CREATE datetime comment '创建时间',"
                                         + "\n  CREATOR varchar(64) comment '创建人',"
                                         + "\n  GMT_MODIFIED datetime comment '修改时间',"
                                         + "\n  MODIFIER varchar(64) comment '修改人',";

    public static void main(String[] args) throws IOException {
        Map<String, String> maps = new LinkedHashMap<String, String>();
        maps = getTableMap();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(// 生成的DDL语句存放目录
                                                                                   "/Users/zhangyang/DEV/gitRepo/javaDemo/src/main/java/com/sleep/myUtil/mysqlDDL/ddlSql.txt")));
        for (Iterator<String> it = maps.keySet().iterator(); it.hasNext();) {
            String tableName = it.next().toString();
            InputStreamReader reader = new InputStreamReader(CreateTableMysql.class.getResourceAsStream(tableName
                                                                                                        + ".txt"));
            BufferedReader rd = new BufferedReader(reader);
            String line;
            StringBuilder sb = new StringBuilder(1000);

            while ((line = rd.readLine()) != null) {
                String[] ss = getValue(line, "\\s+");
                if (ss.length < 4) {
                    System.err.println(line);
                    continue;
                }
                String type = ss[1];
                String isNull = "";
                if ("N".equalsIgnoreCase(ss[2])) {
                    isNull = "NOT NULL";
                }
                StringBuilder columnComment = new StringBuilder(50);
                for (int j = 3; j < ss.length; j++) {
                    columnComment.append(ss[j]);
                }
                sb.append(String.format(coSql, ss[0], type, isNull, columnComment));
            }
            // 去除最后一个逗号
            sb = sb.deleteCharAt(sb.length() - 1);
            String tableComment = maps.get(tableName);
            String fullTableComment = " comment='" + tableComment + "'";
            bufferedWriter.append(String.format(sql, tableComment, tableName, common, sb, fullTableComment));
            System.out.println(String.format(sql, tableComment, tableName, common, sb, fullTableComment));
            rd.close();
        }
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    private static String[] getValue(String line, String d) {
        String[] ss = line.trim().split(d);
        for (int i = 0; i < ss.length; i++) {
            ss[i] = ss[i].trim();
        }
        return ss;
    }

    private static Map<String, String> getTableMap() {
        // 格式<表名，描述>
        Map<String, String> tableMap = new LinkedHashMap<String, String>();
        tableMap.put("gp_pubg_player", "绝地求生玩家表");
        tableMap.put("gp_pubg_match_data", "绝地求生比赛表");
        return tableMap;
    }

}
