
package da_bangiay.Model;

import java.util.Date;


public class ChucVu {
    private int id;
    private boolean chucVu;
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;

    public ChucVu() {
    }

    public ChucVu(int id, boolean chucVu, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.chucVu = chucVu;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChucVu() {
        return chucVu;
    }

    public void setChucVu(boolean chucVu) {
        this.chucVu = chucVu;
    }

    public int getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(int nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public int getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(int nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    
    
    public Object[] toDataRow(){
        return new Object[]{
            this.id,
            this.chucVu,
            this.nguoiTao,
            this.nguoiSua,
            this.ngayTao,
            this.ngaySua
        };
    }
}
