package msysh.test.validationonlambda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InputChild {

	@Size(max = 2)
	@JsonProperty("list")
	private List<@Min(5) @Max(10) Integer> list;
	
	public List<Integer> getList(){
		return list;
	}
	
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "list : " + list;
	}
}
