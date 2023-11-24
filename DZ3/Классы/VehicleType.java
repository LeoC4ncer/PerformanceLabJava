public enum VehicleType {
    TYPE_1("1 — Регистрационные знаки легковых, грузовых автомобилей и автобусов (кроме отнесённых к типу 1Б)"),
    TYPE_2("2 — Регистрационные знаки для автомобильных прицепов и полуприцепов"),
    TYPE_3("3 — Регистрационные знаки для тракторов, самоходных дорожно-строительных и иных машин и прицепов (полуприцепов) к ним");

    private String description;

    VehicleType(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
}
