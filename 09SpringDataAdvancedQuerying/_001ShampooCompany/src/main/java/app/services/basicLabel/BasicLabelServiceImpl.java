package app.services.basicLabel;

import app.model.labels.BasicLabel;
import app.model.labels.Label;
import app.repositories.BasicLabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BasicLabelServiceImpl implements BasicLabelService {

	private final BasicLabelRepository basicLabelRepository;

	@Autowired
	public BasicLabelServiceImpl(BasicLabelRepository basicLabelRepository) { 
		this.basicLabelRepository = basicLabelRepository;
	}


}