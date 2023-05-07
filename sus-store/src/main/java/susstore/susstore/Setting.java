package susstore.susstore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Setting {
    private static Setting instance;
    private String path;

    private String extension;

    private ArrayList<String> plugins;

    private Setting() {
        this.plugins = new ArrayList<String>();
    }

    public static Setting getInstance() {
        if (instance == null)
            instance = new Setting();

        return instance;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath()
    {
        return this.path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension()
    {
        return this.extension;
    }

    public void addPlugins(String plugin) {
        this.plugins.add(plugin);
    }

    public String getPlugin(int index)
    {
        return this.plugins.get(index);
    }

    public void load() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

//            Configuration configuration = gson.fromJson(new FileReader(this.path), Configuration.class);

            Setting setting = gson.fromJson(new FileReader(this.path), Setting.class);

            this.extension = setting.extension;
            this.plugins = setting.plugins;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            Gson gson = new Gson();

            Writer writer = Files.newBufferedWriter(Paths.get(this.path));

            gson.toJson(this, writer);

            writer.flush();

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Setting setting = new Setting();
        setting.setPath("sus-store/src/main/resources/settings.json");
        setting.setExtension("json");
        setting.addPlugins("test.jar");
        setting.addPlugins("tes2.jar");

        setting.save();

        Setting haha = new Setting();

        haha.setPath("sus-store/src/main/resources/settings.json");
        haha.load();

        System.out.println(haha.getPath());
        System.out.println(haha.getExtension());
        System.out.println(haha.getPlugin(0));
        System.out.println(haha.getPlugin(1));
    }
}