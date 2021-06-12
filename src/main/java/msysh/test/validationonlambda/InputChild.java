package msysh.test.validationonlambda;

import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputChild {

	@Size(max = 2)
	@JsonProperty("list")
	private List<@Min(5) @Max(10) Integer> list;
		
	@Override
	public String toString() {
		return "list : " + list;
	}
}
