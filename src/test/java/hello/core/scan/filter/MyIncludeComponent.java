package hello.core.scan.filter;
import java.lang.annotation.*;

@Target(ElementType.TYPE)  //TYPE : Class 레벨
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
