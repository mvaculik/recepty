import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_food_detail.*

class FoodDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Nastavení podrobností o jídle (nahraďte svými údaji)
        foodImageView.setImageResource(R.drawable.apple_pie)
        foodNameTextView.text = "Apple Pie"

        // Kliknutím na tlačítko klikejte na RecipeDetailFragment
        nextButton.setOnClickListener {
            val servings = servingsEditText.text.toString().toInt()
            val recipeDetailFragment = RecipeDetailFragment.newInstance(servings)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, recipeDetailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}
