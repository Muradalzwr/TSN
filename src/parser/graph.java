package parser;

public class graph {
	public int getPath_length_cutoff_abs() {
		return path_length_cutoff_abs;
	}
	public void setPath_length_cutoff_abs(int path_length_cutoff_abs) {
		this.path_length_cutoff_abs = path_length_cutoff_abs;
	}
	public int getPath_length_cutoff_rel() {
		return path_length_cutoff_rel;
	}
	public void setPath_length_cutoff_rel(int path_length_cutoff_rel) {
		this.path_length_cutoff_rel = path_length_cutoff_rel;
	}
	public int getLatency_cutoff_rel() {
		return latency_cutoff_rel;
	}
	public void setLatency_cutoff_rel(int latency_cutoff_rel) {
		this.latency_cutoff_rel = latency_cutoff_rel;
	}
	public int path_length_cutoff_abs ;
	public int path_length_cutoff_rel ;
	public int latency_cutoff_rel ;
	public graph(int path_length_cutoff_abs, int path_length_cutoff_rel, int latency_cutoff_rel) {
		super();
		this.path_length_cutoff_abs = path_length_cutoff_abs;
		this.path_length_cutoff_rel = path_length_cutoff_rel;
		this.latency_cutoff_rel = latency_cutoff_rel;
	}
	
	
}
