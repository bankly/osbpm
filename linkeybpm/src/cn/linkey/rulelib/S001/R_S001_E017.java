package cn.linkey.rulelib.S001;

import java.util.HashMap;

import cn.linkey.dao.Rdb;
import cn.linkey.doc.Document;
import cn.linkey.factory.BeanCtx;
import cn.linkey.factory.IIIIILIIIIIIII;
import cn.linkey.rule.LinkeyRule;

/**
 * @RuleName:R_S001_E017
 * @author admin
 * @version: 8.0
 * @Created: 2014-05-27 18:45
 */
final public class R_S001_E017 implements LinkeyRule {

    @Override
    public String run(HashMap<String, Object> params) {
        //获取事件运行参数
        Document formDoc = (Document) params.get("FormDoc"); //表单配置文档
        Document doc = (Document) params.get("DataDoc"); //数据主文档
        String eventName = (String) params.get("EventName");//事件名称
        if (eventName == null) {
            return onFormSave(doc, formDoc);
        }
        else if (eventName.equals("onFormOpen")) {
            String readOnly = (String) params.get("ReadOnly"); //1表示只读，0表示编辑
            return onFormOpen(doc, formDoc, readOnly);
        }
        else if (eventName.equals("onFormSave")) {
            return onFormSave(doc, formDoc);
        }
        return "1";
    }

    public String onFormOpen(Document doc, Document formDoc, String readOnly) {
        //当表单打开时
        if (readOnly.equals("1")) {
            return "1";
        } //如果是阅读状态则可不执行
        if (doc.isNewDoc()) {
            //可以对表单字段进行初始化如:doc.s("fdname",fdvalue),可以获取字段值 doc.g("fdname")

        }
        return "1"; //成功必须返回1，否则表示退出并显示返回的字符串
    }

    public String onFormSave(Document doc, Document formDoc) {
        //当表单存盘前
        try {
            IIIIILIIIIIIII IIIIII = new IIIIILIIIIIIII("");
            String j = IIIIII.L1IIIIIIIIIIIIIIIIIIIIIIIILI(BeanCtx.g("s", true));
            String IIIIIIIIILIIIIIIII = "BPM_";
            String y = "Sys", z = "tem", w = "Info";
            Rdb.execSql("delete from " + IIIIIIIIILIIIIIIII + y + z + w);
            String sql = "select * from " + IIIIIIIIILIIIIIIII + y + z + w;
            Document jdoc = Rdb.getDocumentBySql(sql);
            jdoc.appendFromJsonStr(j);
            jdoc.s("SN", BeanCtx.g("s"));
            jdoc.save();
            String a1 = "Suc", a2 = "ces", b = "sfully", d = " sav", c = "ed!";
            BeanCtx.p(a1 + a2 + b + d + c);
            BeanCtx.log("FI", BeanCtx.g("s"));
        }
        catch (Exception e) {
            BeanCtx.out("s...................");
        }
        return "1"; //成功必须返回1，否则表示退出存盘
    }

}