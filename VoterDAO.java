package com.evs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.evs.dto.VoteDTO;



public interface VoterDAO extends JpaRepository<VoteDTO, Long> {

	public VoteDTO findById(long id);
	public VoteDTO findByUserId(long id);
	public VoteDTO findByCandidateId(long id);
	public VoteDTO findByVoterIdAndElectionId(long Voterid, Object object);
}
