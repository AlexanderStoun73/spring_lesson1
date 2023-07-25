package com.example.spring_lesson1.hibernate_1.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAМE")
    private String firstName;
    @Column(name = "LAST_NAМE")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @Version                               //Аннотация @Version в JPA (Java Persistence API)
                                            // используется для реализации оптимистической блокировки в базе данных.
                                            // Оптимистическая блокировка позволяет избежать конфликтов при
                                            // одновременном доступе к данным из разных транзакций.
                                            // Это достигается путем добавления специального поля (обычно
                                            // числового или временного штампа) к сущности,
                                            // которое JPA автоматически обновляет при каждом обновлении сущности.
                                            // Когда две или более транзакции пытаются изменить одну и ту же
                                            // сущность одновременно, JPA проверит значение поля version перед
                                            // выполнением фактического обновления в базе данных. Если значения
                                            // version в базе данных и в текущей транзакции совпадают, обновление
                                            // будет выполнено успешно. Однако, если значения не совпадают
                                            // (например, сущность была обновлена другой транзакцией после чтения
                                            // в текущей транзакции), JPA сгенерирует исключение OptimisticLockException.

                                            //Использование аннотации @Version - это мощный механизм для обеспечения
                                            // целостности данных при конкурентном доступе к базе данных из разных
                                            // транзакций. Оптимистическая блокировка позволяет избежать длительных
                                            // блокировок и повышает производительность приложения, сохраняя целостность данных.
    @Column(name = "VERSION")
    private int version;

    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true) //атрибут orphanRemoval
                                // указывает, что после обновления сведений об альбомах записи, которые больше
                                // не существуют в наборе, должны быть удалены из базы данных
                                /*
                                В JPA (Java Persistence API) каскадирование (cascade) - это механизм,
                                который позволяет распространять операции над одной сущностью на связанные
                                с ней сущности. Каскадирование устанавливает, какие операции должны автоматически
                                применяться к связанным сущностям, когда выполняются определенные операции
                                над основной сущностью. Это сокращает необходимость вручную управлять
                                операциями для связанных сущностей и упрощает работу с графами объектов.

                                Когда устанавливается cascade = CascadeType.ALL, это означает, что все операции
                                над основной сущностью (например, persist, remove, merge, refresh, detach)
                                будут каскадироваться на связанные сущности, связанные с этой сущностью
                                через соответствующие отношения.

                                К примеру: Когда устанавливается cascade = CascadeType.ALL, то при сохранении
                                (с помощью метода persist или merge) объекта Parent все его связанные объекты
                                Child, содержащиеся в коллекции children, также будут сохранены.
                                Аналогично, если вы удалите объект Parent (с помощью метода remove),
                                все связанные с ним объекты Child будут также удалены.
                                То же самое будет применяться и к другим операциям, таким как обновление
                                или обновление из базы данных.
                                 */
    private Set<Album> albums;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
                joinColumns = @JoinColumn(name = "SINGER_ID"),
                inverseJoinColumns = @JoinColumn(name = "INSTRUMENT_ID"))
    private Set<Instrument> instruments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", version=" + version +
                ", albums=" + albums +
                ", instruments=" + instruments +
                '}';
    }
}
