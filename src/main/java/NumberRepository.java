import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Optional;

class NumberRepository {

    static EntityManagerFactory FACTORY;
    static EntityManager EM;

    static {
        FACTORY = Persistence.createEntityManagerFactory("jpa-blog-phone-verification");
        EM = FACTORY.createEntityManager();
    }

    static Number save(Number number) {
        EntityTransaction tx = EM.getTransaction();
        tx.begin();
        EM.persist(number);
        tx.commit();
        return number;
    }

    static int remove(String phoneNumber) {
        EntityTransaction tx = EM.getTransaction();
        tx.begin();
        int result = EM.createQuery("DELETE FROM Number n WHERE n.phoneNumber = :phoneNumber")
                .setParameter("phoneNumber", phoneNumber)
                .executeUpdate();
        tx.commit();
        return result;
    }

    static Optional<Number> findByPhoneNumberAndVerified(String phoneNumber, boolean verified) {
        String query = "SELECT n FROM Number n WHERE n.phoneNumber = :phoneNumber AND n.verified = :verified";
        return EM.createQuery(query)
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("verified", verified)
                .getResultList()
                .stream()
                .findFirst();
    }

    static Optional<Number> findByPhoneNumberAndVerificationCode(
            String phoneNumber, String verificationCode) {
        String query = "SELECT n FROM Number n WHERE n.phoneNumber = :phoneNumber AND n.verificationCode = :verificationCode";
        return EM.createQuery(query)
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("verificationCode", verificationCode)
                .getResultList()
                .stream()
                .findFirst();
    }

    static void markAsVerified(String phoneNumber) {
        EntityTransaction tx = EM.getTransaction();
        tx.begin();
        EM.createQuery("UPDATE Number n SET n.verified = :verified WHERE n.phoneNumber = :phoneNumber")
                .setParameter("verified", true)
                .setParameter("phoneNumber", phoneNumber)
                .executeUpdate();
        tx.commit();
    }
}