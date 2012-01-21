package cynosure.conundrum.cryptogram.interfaces;

import java.util.*;

import cynosure.conundrum.cryptogram.dao.WordDTO;

public interface WordsDAO 
{
	void add(WordDTO _dtoWord);
	
	WordDTO findByWord(String _sWord);
	List<WordDTO> findBySymbolized(String _sSymbolized);
	List<WordDTO> findBySolved(String _sSolved);
	List<WordDTO> findBySymbolizedAndSolved(String _sSymbolized, String _sSolved);
	
	int count();
	Map<String, Integer> countOfSymbolized(int _nLength);
	int countBySymbolized(String _sSymbolized);
	int countBySolved(String _sSolved);
	int countBySymbolizedAndSolved(String _sSymbolized, String _sSolved);
}