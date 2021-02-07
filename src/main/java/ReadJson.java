import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.tapestry5.json.JSONArray;
import org.apache.tapestry5.json.JSONObject;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import org.apache.commons.io.output.TeeOutputStream;

public class ReadJson  {
    List<String> list = new ArrayList<String>();

    public String ReadingJson(String txt)  {
        JSONObject o = new JSONObject(txt);
        JSONArray param = o.getJSONArray("products");

        for (int i=0; i< param.length();i++) {
            list.add(param.getJSONObject(i).getString("uit_code"));
        }
        return String.valueOf(list);
    }
}
