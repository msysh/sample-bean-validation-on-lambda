package msysh.test.validationonlambda;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public InputChild getChild() {
		return child;
	}
	
	public void setChild(InputChild child) {
		this.child = child;
	}
	
	@Override
	public String toString() {
		return "list:" + list + " / num : " + num + " / str : " + str + " / child : { " + child + " }";
	}
}
