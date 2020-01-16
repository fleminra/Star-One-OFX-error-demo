import com.webcohesion.ofx4j.client.FinancialInstitution;
import com.webcohesion.ofx4j.client.impl.FinancialInstitutionServiceImpl;
import com.webcohesion.ofx4j.client.impl.LocalResourceFIDataStore;
import com.webcohesion.ofx4j.domain.data.signup.AccountProfile;

public class StarOneOfxErrorDemo {
  public static void main(String[] args) {
    final FinancialInstitutionServiceImpl fiService = new FinancialInstitutionServiceImpl();

    try {
      fiService.setDataStore(new LocalResourceFIDataStore(new java.io.File("institutions.xml")));

      final FinancialInstitution fi = fiService.getFinancialInstitution("321177968");

      System.out.println(fi);

      final String username = "username"; // replace with actual username
      final String password = "password"; // replace with actual password

      final java.util.Collection<AccountProfile> profiles = fi.readAccountProfiles(username, password);
    }
    catch (final java.io.IOException e) {
      e.printStackTrace();
    }
    catch (final com.webcohesion.ofx4j.OFXException e) {
      e.printStackTrace();
    }
  }
}
