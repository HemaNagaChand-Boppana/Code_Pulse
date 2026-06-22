import type { Profile } from "../types/Profile";

type Props = {
  profile: Profile;
};

export default function SummaryCards({
  profile,
}: Props) {

  const totalSolved =
    profile.platforms.reduce(
      (sum, platform) =>
        sum + platform.totalSolved,
      0
    );

  const highestRating =
    Math.max(
      ...profile.platforms.map(
        p => p.highestRating
      )
    );

  return (
    <div className="grid md:grid-cols-3 gap-4">

      <div className="bg-white rounded-xl shadow p-5">
        <p className="text-gray-500">
          Platforms Linked
        </p>

        <h2 className="text-3xl font-bold">
          {profile.platforms.length}
        </h2>
      </div>

      <div className="bg-white rounded-xl shadow p-5">
        <p className="text-gray-500">
          Total Solved / Repos
        </p>

        <h2 className="text-3xl font-bold">
          {totalSolved}
        </h2>
      </div>

      <div className="bg-white rounded-xl shadow p-5">
        <p className="text-gray-500">
          Highest Rating
        </p>

        <h2 className="text-3xl font-bold">
          {highestRating}
        </h2>
      </div>

    </div>
  );
}