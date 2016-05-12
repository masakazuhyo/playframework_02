package controllers;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import models.MyForm;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
public class Application extends Controller {
    
    public static Result index() {
        Form<MyForm> myForm = Form.form(MyForm.class);
        MyForm f = new MyForm();
        f.name = "default value";
        f.os = MyForm.OS_WIN;
        f.inputNum = 50;
        myForm = myForm.fill(f);
        return ok(index.render(myForm,"フォームを入力してください。"));
    }
    public static Result indexPost() {
        Form<MyForm> myForm = Form.form(MyForm.class).bindFromRequest();
        String msg = "";
        if(!myForm.hasErrors()) {
            Map<String,String> result = new LinkedHashMap<>();
            result.put("あなたの名前", myForm.get().name);
            result.put("パスワード", myForm.get().password);
            result.put("check", String.valueOf(myForm.get().checked));
            result.put("radio", String.valueOf(myForm.get().os));
            result.put("country", String.valueOf(myForm.get().country));
            result.put("area", String.valueOf(myForm.get().area));
            result.put("date", String.valueOf(myForm.get().posted));
            result.put("inputNum", String.valueOf(myForm.get().inputNum));
            msg += "value: ";
            for(String key : result.keySet()) {
                msg += key + " : " + result.get(key) + " , ";
            }
        }   else    {
            msg = "ERROR";
        }
        return ok(index.render(myForm,msg));
    }
}