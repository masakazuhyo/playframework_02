//@implicitField = @{ FieldConstructor(myPasswordTemplate.f) }

package models;
import java.util.Date;
import play.data.validation.Constraints.Required;
public class MyForm {
	public static final int OS_WIN = 1;
	public static final int OS_MAC = 2;
	public static final int OS_LINUX = 3;
	public static final int COUNTRY_JAPAN = 1;
	public static final int COUNTRY_US = 2;
	public static final int COUNTRY_UK = 3;
	@Required(message = "This field is required")
	public String name;
	public String password;
	public boolean checked;
	public Integer os;
	public Integer country;
	public String area;
	public Date posted;
	public Integer inputNum;
}