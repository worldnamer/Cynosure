package cynosure.conundrum.cryptogram.interfaces;

import java.util.Set;

public interface LetterHints 
{
	int size();

	void put(char _cKey, Set<Character> _setHints);

	Set<Character> get(char _cKey);

	boolean isPlausible(char[] _szCipher, char[] _aWord);
}