
package da_bangiay.Service;
import da_bangiay.Model.ChucVu;
import da_bangiay.Repository.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChucVu_Service {
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;
    
    public List<ChucVu> getAll(){
        sql = "SELECT id, Name, Create_by, Update_by, Create_at, Upadate_at FROM tbl_ChucVu";
        List<ChucVu> listcv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ChucVu cv = new ChucVu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
                listcv.add(cv);
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ChucVu getCV(int id){
        sql = "SELECT id, Name, Create_by, Update_by, Create_at, Upadate_at FROM tbl_ChucVu WHERE id = ?";
        ChucVu cv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getId());
            rs = ps.executeQuery();
            while(rs.next()){
                cv = new ChucVu(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getDate(5), rs.getDate(6));
            }
            return cv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (ChucVu cv){
        sql = "INSERT INTO tvl_ChucVu (id, Name, Create_by, Update_by, Create_at, Upadate_at) VALUES (?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getId());
            ps.setObject(2, cv.getHoTen());
            ps.setObject(3, cv.getNguoiTao());
            ps.setObject(4, cv.getNguoiSua());
            ps.setObject(5, cv.getNgayTao());
            ps.setObject(6, cv.getNgaySua());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update (int id, ChucVu cv){
        sql = "UPDATE tbl_ChucVu SET Name = ?, Create_by = ?, Update_by = ?, Create_at =? , Upadate_at = ? WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getHoTen());
            ps.setObject(2, cv.getNguoiTao());
            ps.setObject(3, cv.getNguoiSua());
            ps.setObject(4, cv.getNgayTao());
            ps.setObject(5, cv.getNgaySua());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete (int id){
        sql = "DELETE FROM tbl_ChucVu WHERE id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
