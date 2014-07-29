package buildtech.libs;

import org.apache.logging.log4j.LogManager;

public class BuildTechLogger 
{
    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger("BuildTech");

    public static void init() 
    {
        logger.info("BuildTech initialized");
        }

    public static void info(String message) {
    	logger.info(message); 
    	}

    public static void error(String message)
    { 
    	logger.error(message); 
    }

}
