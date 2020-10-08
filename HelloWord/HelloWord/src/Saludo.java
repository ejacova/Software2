import javax.faces.bean.ManagedBean;

@ManagedBean
public class Saludo {
	public String getMensaje() {
		return "Hola Mundo";
	}
}
