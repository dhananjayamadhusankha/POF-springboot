package com.springbootacademy.pointofsale.dto.paginate;

import com.springbootacademy.pointofsale.dto.response.ItemsGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private List<ItemsGetResponseDTO> list;
    private long dataCount;
}
