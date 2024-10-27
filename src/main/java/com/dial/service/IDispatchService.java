package com.dial.service;

import com.dial.dto.DispatchDto;
import com.dial.entities.Dispatch;

public interface IDispatchService {

    Dispatch createDispatch(DispatchDto dispatchDto);
}
