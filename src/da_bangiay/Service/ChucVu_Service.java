
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
        sql = "";
        List<ChucVu> listcv = new ArrayList();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
            }
            return listcv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ChucVu getCV(int id){
        sql = "";
        ChucVu cv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, cv.getId());
            rs = ps.executeQuery();
            
            return cv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int insert (ChucVu cv){
        sql = "";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
           
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int update (int id, ChucVu cv){
        sql = "";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
           
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int delete (int id){
        sql = "";
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
