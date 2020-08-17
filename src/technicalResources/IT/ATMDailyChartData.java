package technicalResources.IT;

public class ATMDailyChartData
{

	String x_axis;
	float manzini;
	float mbabane;
	float total;
	float ezulwini;
	float manzinicsc;
	float matata;
	float mastapha;
	float mfs;
	float nhalnagano;
	float ppk;
	float pos;
	float remoteonus;
	float simunye;
	float siteki;
	float sptc;
	

	
	
	
	public ATMDailyChartData(String year, float manzini, float mbabane,
			float total, float ezulwini, float manzinicsc, float matata,
			float mastapha, float mfs, float nhalnagano, float ppk, float pos,
			float remoteonus, float simunye, float siteki, float sptc) {
		super();
		this.x_axis = year;
		this.manzini = manzini;
		this.mbabane = mbabane;
		this.total = total;
		this.ezulwini = ezulwini;
		this.manzinicsc = manzinicsc;
		this.matata = matata;
		this.mastapha = mastapha;
		this.mfs = mfs;
		this.nhalnagano = nhalnagano;
		this.ppk = ppk;
		this.pos = pos;
		this.remoteonus = remoteonus;
		this.simunye = simunye;
		this.siteki = siteki;
		this.sptc = sptc;
	}
	public String getYear() {
		return x_axis;
	}
	public void setYear(String year) {
		this.x_axis = year;
	}
	public float getManzini() {
		return manzini;
	}
	public void setManzini(float manzini) {
		this.manzini = manzini;
	}
	public float getMbabane() {
		return mbabane;
	}
	public void setMbabane(float mbabane) {
		this.mbabane = mbabane;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getEzulwini() {
		return ezulwini;
	}
	public void setEzulwini(float ezulwini) {
		this.ezulwini = ezulwini;
	}
	public float getManzinicsc() {
		return manzinicsc;
	}
	public void setManzinicsc(float manzinicsc) {
		this.manzinicsc = manzinicsc;
	}
	public float getMatata() {
		return matata;
	}
	public void setMatata(float matata) {
		this.matata = matata;
	}
	public float getMastapha() {
		return mastapha;
	}
	public void setMastapha(float mastapha) {
		this.mastapha = mastapha;
	}
	public float getMfs() {
		return mfs;
	}
	public void setMfs(float mfs) {
		this.mfs = mfs;
	}
	public float getNhalnagano() {
		return nhalnagano;
	}
	public void setNhalnagano(float nhalnagano) {
		this.nhalnagano = nhalnagano;
	}
	public float getPpk() {
		return ppk;
	}
	public void setPpk(float ppk) {
		this.ppk = ppk;
	}
	public float getPos() {
		return pos;
	}
	public void setPos(float pos) {
		this.pos = pos;
	}
	public float getRemoteonus() {
		return remoteonus;
	}
	public void setRemoteonus(float remoteonus) {
		this.remoteonus = remoteonus;
	}
	public float getSimunye() {
		return simunye;
	}
	public void setSimunye(float simunye) {
		this.simunye = simunye;
	}
	public float getSiteki() {
		return siteki;
	}
	public void setSiteki(float siteki) {
		this.siteki = siteki;
	}
	public float getSptc() {
		return sptc;
	}
	public void setSptc(float sptc) {
		this.sptc = sptc;
	}
	public ATMDailyChartData(){}
	public String GenerateJSonChartDataYearWisePassPercentage(String jsonp) {
		// TODO Auto-generated method stub
		return null;
	}

	
}