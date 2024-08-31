package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.UserDTO;
import in.bushansirgur.springboot.crudapi.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        if (user == null){
            return null;
        }

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;        
    }
}
