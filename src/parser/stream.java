package parser;

public class stream {
	public String id ;
	  public String sources ;
	  public stream() {
		super();
		// TODO Auto-generated constructor stub
	}
	  public String destinations ;
	  public  int cycle_time_ns ;
	  public  int frame_size_b ;
	  public  int max_latency_ns ;
	  public  String  deadline_ns ;
	  public  int redundancy ;
	  public  int _imd_o_lb ;
	  public  int _imd_o_ub ;
	  public  int _imd_fo_lb ;
	  public  int _imd_fo_ub ;
	  public  boolean _imd_ctrl ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSources() {
		return sources;
	}
	public void setSources(String sources) {
		this.sources = sources;
	}
	public String getDestinations() {
		return destinations;
	}
	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}
	public int getCycle_time_ns() {
		return cycle_time_ns;
	}
	public void setCycle_time_ns(int cycle_time_ns) {
		this.cycle_time_ns = cycle_time_ns;
	}
	public int getFrame_size_b() {
		return frame_size_b;
	}
	public void setFrame_size_b(int frame_size_b) {
		this.frame_size_b = frame_size_b;
	}
	public int getMax_latency_ns() {
		return max_latency_ns;
	}
	public void setMax_latency_ns(int max_latency_ns) {
		this.max_latency_ns = max_latency_ns;
	}
	public String getDeadline_ns() {
		return deadline_ns;
	}
	public void setDeadline_ns(String deadline_ns) {
		this.deadline_ns = deadline_ns;
	}
	public int getRedundancy() {
		return redundancy;
	}
	public void setRedundancy(int redundancy) {
		this.redundancy = redundancy;
	}
	public int get_imd_o_lb() {
		return _imd_o_lb;
	}
	public void set_imd_o_lb(int _imd_o_lb) {
		this._imd_o_lb = _imd_o_lb;
	}
	public int get_imd_o_ub() {
		return _imd_o_ub;
	}
	public void set_imd_o_ub(int _imd_o_ub) {
		this._imd_o_ub = _imd_o_ub;
	}
	public int get_imd_fo_lb() {
		return _imd_fo_lb;
	}
	public void set_imd_fo_lb(int _imd_fo_lb) {
		this._imd_fo_lb = _imd_fo_lb;
	}
	public int get_imd_fo_ub() {
		return _imd_fo_ub;
	}
	public void set_imd_fo_ub(int _imd_fo_ub) {
		this._imd_fo_ub = _imd_fo_ub;
	}
	public boolean is_imd_ctrl() {
		return _imd_ctrl;
	}
	public void set_imd_ctrl(boolean _imd_ctrl) {
		this._imd_ctrl = _imd_ctrl;
	}
	public stream(String id, String sources, String destinations, int cycle_time_ns, int frame_size_b, int max_latency_ns,
			String deadline_ns, int redundancy, int _imd_o_lb, int _imd_o_ub, int _imd_fo_lb, int _imd_fo_ub,
			boolean _imd_ctrl) {
		super();
		this.id = id;
		this.sources = sources;
		this.destinations = destinations;
		this.cycle_time_ns = cycle_time_ns;
		this.frame_size_b = frame_size_b;
		this.max_latency_ns = max_latency_ns;
		this.deadline_ns = deadline_ns;
		this.redundancy = redundancy;
		this._imd_o_lb = _imd_o_lb;
		this._imd_o_ub = _imd_o_ub;
		this._imd_fo_lb = _imd_fo_lb;
		this._imd_fo_ub = _imd_fo_ub;
		this._imd_ctrl = _imd_ctrl;
	}
}
