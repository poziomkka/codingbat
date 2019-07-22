import org.junit.Assert;
import org.junit.Test;

public class String3Test {

    @Test
    public void given_HelloThere_when_WithoutStringLlo_then_HeThere() {
        Assert.assertEquals("He there", String3.withoutString("Hello there", "llo"));
    }

    @Test
    public void given_HelloThere_when_WithoutStringE_then_HlloThr() {
        Assert.assertEquals("Hllo thr", String3.withoutString("Hello there", "e"));
    }

    @Test
    public void given_HelloThere_when_WithoutStringX_then_HelloThere() {
        Assert.assertEquals("Hello there", String3.withoutString("Hello there", "x"));
    }

}