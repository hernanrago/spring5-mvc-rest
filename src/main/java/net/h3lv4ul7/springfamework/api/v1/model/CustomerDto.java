package net.h3lv4ul7.springfamework.api.v1.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerDto {

	private Long id;
	@NonNull private String name;
}
