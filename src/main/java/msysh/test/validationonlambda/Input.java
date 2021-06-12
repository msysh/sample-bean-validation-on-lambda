package msysh.test.validationonlambda;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Input {
	
	@Size(max = 2)
	@JsonProperty("list")
	private List<@Min(5) @Max(10) Integer> list;
	
	@Min(5)
	@Max(10)
	@JsonProperty("num")
	private Integer num;
	
	@NotNull
	@JsonProperty("str")
	private String str;
	
	@NotNull
	@Valid
	@JsonProperty("child")
	private InputChild child;
	
	@Override
	public String toString() {
		return "list:" + list + " / num : " + num + " / str : " + str + " / child : { " + child + " }";
	}
}
