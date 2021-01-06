package org.hino.sbb.dto;

public class StationDTO extends AbstractDTO {

    private long roadId;

    private String name;

    public StationDTO() {
    }

    public StationDTO(long id, long roadId, String name) {
        super.setId(id);
        this.roadId = roadId;
        this.name = name;
    }

    public void setRoadId(Long road_id) {
        this.roadId = road_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRoadId() {
        return roadId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return roadId + name;
    }
}
