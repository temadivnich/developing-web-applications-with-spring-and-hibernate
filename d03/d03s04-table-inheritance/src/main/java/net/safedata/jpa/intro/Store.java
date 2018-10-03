package net.safedata.jpa.intro;

import net.safedata.spring.training.AbstractEntity;
import net.safedata.spring.training.Manager;
import net.safedata.spring.training.StoreSection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "storeTypeId",
        discriminatorType = DiscriminatorType.INTEGER
)
public class Store extends AbstractEntity {

    @Id
    @GeneratedValue(generator = "store_sequence_generator")
    @SequenceGenerator(name = "store_sequence_generator",
            sequenceName="store_sequence", allocationSize = 1)
    private int id;

    @Column(nullable = false, length = 50, insertable = true)
    private String name;

    @Column(nullable = false, length = 50, insertable = true)
    private String location;

    @OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StoreSection> storeSections;

    @PrePersist
    public void beforeSave() {
        System.out.println("Saving the Product " + getId());
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "StoreManager",
            joinColumns = {
                // navigating from the 'StoreManager' to the 'Store'
                @JoinColumn(name = "storeId", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                // navigating from the 'StoreManager' to the 'Manager'
                @JoinColumn(name = "managerId", referencedColumnName = "id")
            }
    )
    private Set<Manager> storeManagers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    public Set<Manager> getStoreManagers() {
        return storeManagers;
    }

    public void setStoreManagers(Set<Manager> storeManagers) {
        this.storeManagers = storeManagers;
    }

    public Set<StoreSection> getStoreSections() {
        return storeSections;
    }

    public void setStoreSections(Set<StoreSection> storeSections) {
        this.storeSections = storeSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return id == store.id &&
                Objects.equals(name, store.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
