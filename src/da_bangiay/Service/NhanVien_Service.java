
package da_bangiay.Service;
import da_bangiay.Model.NhanVien;
import da_bangiay.Repository.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_Service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<NhanVien> getAll(){
        sql = "SELECT id, id_ChucVu, Name, Email, SĐT, MatKhau, DiaChi, Status, Create_by, Update_by, Create_at, Upadate_at FROM tbl_NhanVien";
        List<NhanVien> listnv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getDate(10), rs.getDate(11));
                listnv.add(nv);
            }
            return listnv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public NhanVien getNV(int id_ChucVu){
        sql = "SELECT id, id_ChucVu, Name, Email, SĐT, MatKhau, DiaChi, Status, Create_by, Update_by, Create_at, Upadate_at FROM tbl_NhanVien WHERE id_ChucVu = ?";
        NhanVien nv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId_ChucVu());
            rs = ps.executeQuery();
            while(rs.next()){
                nv = new NhanVien(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getDate(10), rs.getDate(11));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (NhanVien nv){
        sql = "INSERT INTO tbl_NhanVien (id,id_ChucVu, Name,Email, SĐT, MatKhau, DiaChi, Status, Create_by, Update_by, Create_at, Upadate_at) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getId());
            ps.setObject(2, nv.getId_ChucVu());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.getEmail());
            ps.setObject(5, nv.getSDT());
            ps.setObject(6, nv.getMatKhau());
            ps.setObject(7, nv.getDiaChi());
            ps.setObject(8, nv.getTrangThai());
            ps.setObject(9, nv.getNguoiTao());
            ps.setObject(10, nv.getNguoiSua());
            ps.setObject(11, nv.getNgayTao());
            ps.setObject(12, nv.getNgaySua());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update (String id_ChucVu, NhanVien nv){
        sql =  "UPDATE tbl_NhanVien SET Name = ?, Email = ?, SĐT = ?, MatKhau = ?, DiaChi = ?, Status = ?, Create_by = ?, Update_by = ?, Create_at = ?, Upadate_at = ? WHERE id_ChucVu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
             ps.setObject(1, nv.getHoTen());
            ps.setObject(2, nv.getEmail());
            ps.setObject(3, nv.getSDT());
            ps.setObject(4, nv.getMatKhau());
            ps.setObject(5, nv.getDiaChi());
            ps.setObject(6, nv.getTrangThai());
            ps.setObject(7, nv.getNguoiTao());
            ps.setObject(8, nv.getNguoiSua());
            ps.setObject(9, nv.getNgayTao());
            ps.setObject(10, nv.getNgaySua());
            ps.setObject(11, id_ChucVu);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete(int id_ChucVu){
        sql = "DELETE FROM tbl_NhanVien WHERE id_ChucVu = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id_ChucVu);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
