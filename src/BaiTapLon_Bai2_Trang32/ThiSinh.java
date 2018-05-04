package BaiTapLon_Bai2_Trang32;

public class ThiSinh {
	public String soBaoDanh;
	public String hoTen;
	public String dienThoai;
	public float diemLyThuyet, diemThucHanh;
	
	public ThiSinh()
	{
		
	}
	
	public ThiSinh(String soBaoDanh, String hoTen, String dienThoai, float diemLyThuyet, float diemThucHanh) {
		setSoBaoDanh(soBaoDanh);
		setHoTen(hoTen);
		setDienThoai(dienThoai);
		setDiemLyThuyet(diemLyThuyet);
		setDiemThucHanh(diemThucHanh);
	}
	
	public String getSoBaoDanh() {
		return soBaoDanh;
	}
	public void setSoBaoDanh(String soBaoDanh) {
		this.soBaoDanh = soBaoDanh;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public float getDiemLyThuyet() {
		return diemLyThuyet;
	}
	public void setDiemLyThuyet(float diemLyThuyet) {
		this.diemLyThuyet = diemLyThuyet;
	}
	public float getDiemThucHanh() {
		return diemThucHanh;
	}
	public void setDiemThucHanh(float diemThucHanh) {
		this.diemThucHanh = diemThucHanh;
	}
	
}
