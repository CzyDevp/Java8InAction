package chapter11;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
public class CompletableFutureTwoExample {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Arrays.asList("A","B","C","D");
      list.stream().map(data->CompletableFuture.supplyAsync(()->"Processing:"+data)).
                map(compFuture->compFuture.thenAccept(s->System.out.println(s)));
       // System.out.println(L);
    }
} 