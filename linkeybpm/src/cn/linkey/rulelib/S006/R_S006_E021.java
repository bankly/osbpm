package cn.linkey.rulelib.S006;

import java.util.HashMap;

import cn.linkey.dao.Rdb;
import cn.linkey.doc.Document;
import cn.linkey.rule.LinkeyRule;
import cn.linkey.util.Tools;

/**
 * @RuleName:所有用户列表事件
 * @author admin
 * @version: 8.0
 * @Created: 2015-01-04 15:43
 */
final public class R_S006_E021 implements LinkeyRule {
    @Override
    public String run(HashMap<String, Object> params) throws Exception {
        Document configdoc = (Document) params.get("ConfigDoc"); //grid配置文档
        Document doc = (Document) params.get("DataDoc"); //数据主文档
        String eventName = (String) params.get("EventName");//事件名称
        if (eventName.equals("formatRowData")) {
            formatRowData(doc);
        }
        else if (eventName.equals("formatSql")) {
            return formatSql(configdoc);
        }
        else if (eventName.equals("getTotalNum")) {
            return getTotalNum(configdoc);
        }
        else if (eventName.equals("onDataSourceOpen")) {
            onDataSourceOpen(configdoc);
        }
        return "";
    }

    /**
     * 数据源打开时执行本方法，可以动态修改sqlwhere条件
     **/
    public void onDataSourceOpen(Document configdoc) throws Exception {
        //通过操作configdoc可以在数据源打开时动态修改配置参数
        //动态修改SqlWhere选择条件: configdoc.s("SqlWhere","id='1001'");

    }

    public void formatRowData(Document doc) throws Exception {
        //doc对像对应数据库表中的记录可修改或获取所有字段
        //格式化列数据如: doc.s("Subject",doc.g("Subject")+doc.g("UserName")); 可重新格式化Subject字段
        String sql = "select folderName from BPM_OrgUserWithMainDept where Userid='" + doc.g("Userid") + "'";
        String folderName = Rdb.getValueBySql(sql);
        if (Tools.isBlank(folderName)) {
            folderName = "-无-";
        }
        doc.s("FolderName", folderName);
    }

    public String formatSql(Document configdoc) throws Exception {
        /*
         * configdoc表示当前json数据源的配置信息 自定义复杂的sql语句，当配置中的where条件无法满足时可以实现自定义sql String sql="select * from "+configDoc.g("SqlTableName")+" where WF_OrUnid='"+BeanCtx.getParameter("fromurlarg")+"'"
         */
        return ""; //返回空表示使用配置值
    }

    public String getTotalNum(Document configdoc) throws Exception {
        /* 与formatSql一起使用返回文档总数 */
        return "0";
    }

}