"""
Alphabet Value Calculator - Assigns numerical values to letters (a=1, b=2, etc.)

@author Marc McGough
@date 11/03/2025
"""


def get_letter_value(letter):
    """
    Returns the numerical value of a letter (a=1, b=2, c=3, etc.)

    Args:
        letter: the letter to get the value for

    Returns:
        int: the numerical value (1-26), or 0 if not a valid letter
    """
    letter = letter.lower()
    if 'a' <= letter <= 'z':
        return ord(letter) - ord('a') + 1
    return 0


def get_word_value(word):
    """
    Calculates the sum of all letter values in a word

    Args:
        word: the word to calculate the value for

    Returns:
        int: the sum of all letter values
    """
    total = 0
    for char in word:
        total += get_letter_value(char)
    return total


def display_alphabet():
    """Displays the alphabet with corresponding numerical values"""
    print("\nAlphabet Numerical Values:")
    print("==========================")
    for i in range(26):
        char = chr(ord('a') + i)
        print(f"{char} = {get_letter_value(char)}")


def main():
    """Main function to run the alphabet value calculator"""
    print("Welcome to Alphabet Value Calculator!")

    display_alphabet()

    print("\nEnter a letter or word to get its numerical value (or 'quit' to exit):")

    while True:
        user_input = input("\n> ").strip()

        if user_input.lower() == 'quit':
            print("Goodbye!")
            break

        if not user_input:
            continue

        if len(user_input) == 1:
            value = get_letter_value(user_input)
            if value > 0:
                print(f"Letter '{user_input}' has a value of: {value}")
            else:
                print("Invalid letter. Please enter a letter from a-z.")
        else:
            word_value = get_word_value(user_input)
            print(f"Word '{user_input}' has a total value of: {word_value}")

            # Show individual letter values
            breakdown = []
            for char in user_input:
                value = get_letter_value(char)
                if value > 0:
                    breakdown.append(f"{char}={value}")

            if breakdown:
                print(f"Breakdown: {' + '.join(breakdown)}")


if __name__ == "__main__":
    main()
