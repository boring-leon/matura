# ctrl +  makes text bigger

# File reading
The file has to be located at the root dir of the project.
DO NOT PLACE IT WITHIN "src" dir!
```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 public static void main(String[] args) throw IOException {

        try (BufferedReader br = new BufferedReader(new FileReader("plik.txt"))) {
            String line;
            while((line = br.readLine()) != null){
                //access current line
            }
        }
    }

```
# File writing
The file will be created at the root dir of the project
```java
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

public static void main(String[] args) throws IOException {
	FileWriter fr = new FileWriter(new File("test.txt"));
	PrintWriter pw = new PrintWriter(fr);
	pw.println("bla bla") //writes in new line
	pw.print("blah blah"); //writes in same line
	pw.close();
}

```