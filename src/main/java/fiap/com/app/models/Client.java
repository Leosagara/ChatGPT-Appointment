package fiap.com.app.models;

import fiap.com.app.models.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client")
@AttributeOverride(name = "id", column = @Column(name = "client_id"))
public class Client extends BaseEntity {
    private String client_name;
    private String client_email;
    private String client_birthday;
    private String client_cell;
}
