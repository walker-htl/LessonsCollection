import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class LowerCaseFilterWriter extends FilterWriter {
    LowerCaseFilterWriter(Writer out) {
        super(out);
    }

    public void write(String str) throws IOException {
        super.write(str.toLowerCase());
    }
}
