package parser;

public class nodes {
	public String id ;
	public boolean is_switch;
	public int processing_delay_ns ;
	public int fwd_header_b ;
	public int queues_per_port ;
	public  double impp1 ; 
	public  double impp2 ; 

	
public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isIs_switch() {
		return is_switch;
	}

	public void setIs_switch(boolean is_switch) {
		this.is_switch = is_switch;
	}

	public int getProcessing_delay_ns() {
		return processing_delay_ns;
	}

	public void setProcessing_delay_ns(int processing_delay_ns) {
		this.processing_delay_ns = processing_delay_ns;
	}

	public int getFwd_header_b() {
		return fwd_header_b;
	}

	public void setFwd_header_b(int fwd_header_b) {
		this.fwd_header_b = fwd_header_b;
	}

	public int getQueues_per_port() {
		return queues_per_port;
	}

	public void setQueues_per_port(int queues_per_port) {
		this.queues_per_port = queues_per_port;
	}

	public double getImpp1() {
		return impp1;
	}

	public void setImpp1(double impp1) {
		this.impp1 = impp1;
	}

	public double getImpp2() {
		return impp2;
	}


	public void setImpp2(double impp2) {
		this.impp2 = impp2;
	}



	public nodes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public nodes(String id, boolean is_switch, int processing_delay_ns, int fwd_header_b, int queues_per_port, double impp1,
			double impp2) {
		super();
		this.id = id;
		this.is_switch = is_switch;
		this.processing_delay_ns = processing_delay_ns;
		this.fwd_header_b = fwd_header_b;
		this.queues_per_port = queues_per_port;
		this.impp1 = impp1;
		this.impp2 = impp2;
}
}
