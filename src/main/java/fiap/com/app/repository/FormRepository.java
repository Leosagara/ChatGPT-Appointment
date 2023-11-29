package fiap.com.app.repository;

import fiap.com.app.models.Client;
import fiap.com.app.models.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form,Long> {
}
