
class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
	val arrayList = ArrayList<List<Int>>()
	nums.sort() // sort necessary to filter out duplicates

	for (i in 0 until nums.size) {
		if (i > 0 && nums[i] == nums[i - 1]) {
			continue //since sorted, it is ok to skip and remove duplicates.
		}

		for (j in i + 1 until nums.size) {
			if (j > i + 1 && nums[j] == nums[j - 1]) {
				continue //since sorted, it is ok to skip and remove duplicates.
			}

			val friend = target - nums[i] - nums[j]
			var left = j + 1
			var right = nums.size - 1

			while (left < right) {
				val sumIJ = nums[left] + nums[right]
				when {
					sumIJ < friend -> left++
					sumIJ > friend -> right--
					sumIJ == friend -> {
						//detect duplicates, since they are in order, duplicates will be adjacent.
						//so it is sufficient to compare to previous value
						if (left > j + 1 && right < nums.size - 1) {
							if (nums[left] != nums[left - 1] || nums[right] != nums[right + 1]) {
								arrayList.add(listOf(nums[i], nums[j], nums[left], nums[right]))
							}
						} else {
							arrayList.add(listOf(nums[i], nums[j], nums[left], nums[right]))
						}

						left++
						right--
					}
				}
			}

		}
	}

	return arrayList
}
}
