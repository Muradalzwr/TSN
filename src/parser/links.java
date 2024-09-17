package parser;

public class links {
	public String key ;
	public String source ;
	public links() {
		super();
		// TODO Auto-generated constructor stub
	}
	public links(String key, String source, String target, int propagation, int delay) {
		super();
		this.key = key;
		this.source = source;
		this.target = target;
		this.propagation = propagation;
		this.delay = delay;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getPropagation() {
		return propagation;
	}
	public void setPropagation(int propagation) {
		this.propagation = propagation;
	}
	public int getDelay() {
		return delay;
	}
	public void setDelay(int delay) {
		this.delay = delay;
	}
	public String target ;
	public int propagation ;
	public int delay ;
}
