import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
public class AsColumns {
    File file;

    public void createFile(String s) throws IOException {
        file = new File("src/main/resources/"+s+".text");
        System.out.println(file.createNewFile());
    }

    public void toColumn(int k) {
        //creates a string consisting of every i-th element in the desired list concatenated w/spaces
        //in between
        BiFunction<Integer,List<String>, String> modulo= (i,s)-> IntStream.range(0,s.size())
                .filter(x->x%k==i)
                .mapToObj(s::get)
                .reduce("",(t1,t2)->t1+t2+" ");
        try {
      List<String> list= Files.readAllLines(Paths.get("src/main/resources/1through25.text"),Charset.defaultCharset());
        //now to write the k lines to the file of choice functionally:
            FileWriter editor = new FileWriter(file.getPath());
            IntStream.range(0,k).forEach(i-> {
                try {
                    editor.write(modulo.apply(i,list)+"\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            editor.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
