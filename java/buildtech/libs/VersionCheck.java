package buildtech.libs;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import net.minecraft.nbt.NBTTagCompound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import com.sun.istack.internal.logging.Logger;

public class VersionCheck 
{

    public static boolean newVersionAvailable = false;
    public static String newVersionNumber = "";
    public static String currentVersion = "@MODVERSION@";
    public static String[] changelog;
    public static int numLines = 0;

    public static void start(){
        VersionCheckThread thread = new VersionCheckThread();
        thread.start();
    }

    private static class VersionCheckThread extends Thread {

        @Override
        public void run() {
            BuildTechLogger.info("BuildTech VersionChecker initiated, current version: @VERSION@");
            try {

                URL version = new URL("https://github.com/UniversalRed/BuildTech/tree/master/resources/changelogs/version.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(version.openStream()));
                newVersionNumber = reader.readLine();
                if (!currentVersion.equals(newVersionNumber)) {
                    newVersionAvailable = true;
                    BuildTechLogger.info("There is a newer version of BuildTech available (" + newVersionNumber + ") please consider updating :)");
                    URL changelogURL = new URL("https://github.com/UniversalRed/BuildTech/tree/master/resources/changelogs/" + newVersionNumber);
                    BufferedReader changelogReader = new BufferedReader((new InputStreamReader(changelogURL.openStream())));
                    String line;
                    ArrayList<String> changelogList = new ArrayList<String>();
                    while ((line = changelogReader.readLine()) != null) {
                        changelogList.add(line);
                        numLines++;
                    }
                    changelog = new String[10];
                    changelogList.toArray(changelog);
                    pingVersionChecker();
                }

            } catch (Throwable e) {
                BuildTechLogger.error("BuildTech VersionChecker failed! We're doomed *_>*");
                e.printStackTrace();
            }
        }
        public void pingVersionChecker(){
            if (Loader.isModLoaded("VersionChecker")){
                NBTTagCompound tag = new NBTTagCompound();
                tag.setString("modDisplayName", "BuildTech");
                tag.setString("oldVersion", currentVersion);
                tag.setString("newVersion", newVersionNumber);
                tag.setString("updateUrl", "http://minecraft.curseforge.com/mc-mods/79581-buildtech/files");
                tag.setBoolean("isDirectLink", false);
                StringBuilder builder = new StringBuilder();
                for (int t = 0; t < numLines; t++){
                    builder.append(changelog[t]).append("/n");
                }
                tag.setString("changeLog", builder.toString());
                FMLInterModComms.sendRuntimeMessage("BuildTech", "VersionChecker", "addUpdate", tag);
            }
        }
    }
}
