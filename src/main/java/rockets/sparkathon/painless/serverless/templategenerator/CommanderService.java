package rockets.sparkathon.painless.serverless.templategenerator;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class CommanderService {

    private final String commandLineUtility = System.getenv("GIT_HOME") + "\\bin\\bash.exe";

    public String invokeCommandLine(String command, String... arguments) throws Exception {
        try {
            List<String> commands = new ArrayList<>();
            commands.add(commandLineUtility);
            commands.add("-c");
            commands.add(command + " " + String.join(" ", arguments));

            ProcessBuilder processBuilder = new ProcessBuilder(commands);
            Map<String, String> env = processBuilder.environment();
            String path = env.get("Path");
            String libPath = System.getProperty("java.library.path");
            path = path + File.pathSeparator + libPath; // should actually include null checks
            env.put("Path", path);
            env.put("user.home", System.getProperty("user.home"));
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
            int exitValue = process.waitFor();
            System.out.println(sb);
            if (exitValue != 0) {
                System.out.println("Error");
                //handleProcessError(process.getErrorStream());
            }
            return sb.toString();

        } catch (Exception e) {
            //LOGGER.error("Failed to invoke script command: {0} ", e, command);
            throw e;
        }
    }


    private void handleProcessError(InputStream stdError) throws Exception {
        StringBuilder errorStringBuilder = new StringBuilder();
        try (Reader reader = new BufferedReader(new InputStreamReader(stdError, Charset.forName(StandardCharsets.UTF_8.name())))) {
            int c;
            while ((c = reader.read()) != -1) {
                errorStringBuilder.append((char) c);
            }
        }
        throw new RuntimeException("Error while invoking script command: " + errorStringBuilder.toString());
    }

    public void checkPrerequisites() {
        if (System.getProperty("os.name").toLowerCase().startsWith("windows") && System.getenv("GIT_HOME") == null) {
            System.out.println("Error. when running on a windows system GIT_HOME env variable should be assigned");
            throw new RuntimeException("Error. when running on a windows system GIT_HOME env variable should be assigned");
        }

    }

}
